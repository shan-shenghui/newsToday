package com.wd.untils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class FileUtil {
	private static Log logger = LogFactory.getLog(FileUtil.class);

	public static String escapeFileName(String fileName) {
		if (fileName != null) {
			fileName = org.apache.commons.lang.StringUtils.replace(fileName,
					"*", "×");
			fileName = org.apache.commons.lang.StringUtils.replace(fileName,
					"?", "？");
		}
		return fileName;
	}

	public static void main(String[] args) {
		System.out.println(getShortName("", true));
		System.out.println(getShortName(".", false));
		System.out.println(getShortName("aa.b", false));
		System.out.println(getShortName("a/aa.b", false));
	}

	public static String getShortName(String path, boolean includeExtName) {
		String shortName = path;
		if (path != null) {
			StringBuffer sb = new StringBuffer();
			char[] cList = path.toCharArray();
			boolean start = false;
			if (includeExtName) {
				start = true;
			} else {
				if (path.indexOf(".") > -1) {
					start = false;
				} else {
					start = true;
				}
			}
			for (int i = cList.length - 1; i >= 0; i--) {
				char c = cList[i];
				if (c == '\\' || c == '/') {
					break;
				} else {
					if (start == false && c == '.') {
						start = true;
						continue;
					}
					//
					if (start) {
						sb.insert(0, c);
					}
				}
			}
			shortName = sb.toString();
		}
		return shortName;
	}

	public static void readToBuffer(StringBuffer buffer, InputStream is,
			String charSetOfFile) throws IOException {
		if (buffer == null || is == null || charSetOfFile == null)
			return;
		//
		try {
			InputStreamReader isr = new InputStreamReader(is, charSetOfFile);
			try {
				BufferedReader reader = new BufferedReader(isr);
				try {
					String line;
					line = reader.readLine();
					while (line != null) {
						buffer.append(line);
						buffer.append("\n");
						line = reader.readLine();
					}
				} finally {
					reader.close();
				}
			} finally {
				isr.close();
			}
		} finally {
			is.close();
		}
	}

	public static void readToMap(Map<String, String> map, InputStream is,
			String charSetOfFile) throws IOException {
		if (map == null || is == null || charSetOfFile == null)
			return;
		//
		try {
			String line;
			InputStreamReader isr = new InputStreamReader(is, charSetOfFile);
			try {
				BufferedReader reader = new BufferedReader(isr);
				try {
					line = reader.readLine();
					int pos = 0;
					while (line != null) {
						if (!line.trim().startsWith("#")) {
							pos = line.indexOf("=");
							if (pos > -1) {
								map.put(line.substring(0, pos),
										line.substring(pos + 1));
							}
						}
						//
						line = reader.readLine();
					}
				} finally {
					reader.close();
				}
			} finally {
				isr.close();
			}
		} finally {
			is.close();
		}
	}

	public static void readToList(List<String> lines, InputStream is,
			String charSetOfFile) throws IOException {
		if (lines == null || is == null || charSetOfFile == null)
			return;
		//
		try {
			String line;
			InputStreamReader isr = new InputStreamReader(is, charSetOfFile);
			try {
				BufferedReader reader = new BufferedReader(isr);
				try {
					line = reader.readLine();
					while (line != null) {
						lines.add(line);
						line = reader.readLine();
					}
				} finally {
					reader.close();
				}
			} finally {
				isr.close();
			}
		} finally {
			is.close();
		}
	}

	public static File makeSureFileExist(File file) throws IOException {
		if (file != null) {
			File parent = file.getParentFile();
			if (!parent.exists()) {
				if (!parent.mkdirs()) {
					throw new RuntimeException("can not create dir "
							+ file.getAbsolutePath());
				}
			}
			//
			if (!file.exists()) {
				if (!file.createNewFile()) {
					throw new RuntimeException("can not create file "
							+ file.getAbsolutePath());
				}
			}
			//
			return file;
		} else {
			return null;
		}
	}

	public static File makeSureDirExist(File dir) throws IOException {
		if (dir != null) {
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					throw new RuntimeException("can not create dir "
							+ dir.getAbsolutePath());
				}
			}
			//
			return dir;
		} else {
			return null;
		}
	}

	public static void writeFile(String filePath, String data) {
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;
		try {
			File file = new File(filePath);
			file = makeSureFileExist(file);
			fos = new FileOutputStream(file);
			writer = new OutputStreamWriter(fos, "UTF-8");
			writer.write(data);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			try {
				if (writer != null) {
					writer.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception localException1) {
			}
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception localException2) {
			}
		}
	}

	public static String readFile(String filePath) {
		StringBuffer buffer = new StringBuffer();
		try {
			File file = new File(filePath);
			FileInputStream fis = null;
			BufferedReader breader = null;
			try {
				fis = new FileInputStream(file);
				InputStreamReader isReader = new InputStreamReader(fis, "UTF-8");
				breader = new BufferedReader(isReader);
				String line;
				while ((line = breader.readLine()) != null) {
					// String line;
					buffer.append(line);
					buffer.append("\r\n");
				}
				breader.close();
				isReader.close();
				fis.close();
			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return buffer.toString();
	}

	public static String bytes2String(byte[] bytes, String charset)
			throws IOException {
		InputStream input = new ByteArrayInputStream(bytes);
		try {
			return inputStream2String(input, charset);
		} finally {
			input.close();
		}
	}

	public static String inputStream2String(InputStream input, String charset)
			throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input,
				charset));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line + "\n");
		}
		return buffer.toString();
	}

	public static String getCharset(File file) {
		String charset = "GBK";
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if ((first3Bytes[0] == -1) && (first3Bytes[1] == -2)) {
				charset = "UTF-16LE";
				checked = true;
			} else if ((first3Bytes[0] == -2) && (first3Bytes[1] == -1)) {
				charset = "UTF-16BE";
				checked = true;
			} else if ((first3Bytes[0] == -17) && (first3Bytes[1] == -69)
					&& (first3Bytes[2] == -65)) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();

			if (!checked) {
				while ((read = bis.read()) != -1) {
					if (read >= 240) {
						break;
					}
					if ((128 <= read) && (read <= 191))
						break;
					if ((192 <= read) && (read <= 223)) {
						read = bis.read();
						if ((128 > read) || (read > 191)) {
							break;
						}

					} else if ((224 <= read) && (read <= 239)) {
						read = bis.read();
						if ((128 > read) || (read > 191))
							break;
						read = bis.read();
						if ((128 > read) || (read > 191))
							break;
						charset = "UTF-8";
						break;
					}

				}

			}

			bis.close();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(e);
			}
		}
		return charset;
	}

	public static boolean isExist(String filePath) {
		return new File(filePath).exists();
	}

	public static String getClassesPath() {
		String templatePath = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		if (templatePath.startsWith("file:/")) {
			templatePath = templatePath.replaceFirst("file:/", "");
		}
		templatePath = templatePath.replace("/", File.separator);
		return templatePath;
	}

	// 转换文件大小
	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

}
