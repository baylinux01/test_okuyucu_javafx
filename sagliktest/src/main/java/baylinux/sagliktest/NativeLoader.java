package baylinux.sagliktest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NativeLoader {
	
	 public static void loadOpenCV() throws IOException 
	 {
		 String os = System.getProperty("os.name").toLowerCase();

		 if (os.contains("win")) 
		 {
		     // Windows
//			 	System.load("C:\\Windows\\System32\\msvcp140.dll");
//			 	System.load("C:\\Windows\\System32\\vcruntime140.dll");
//			 	System.load("C:\\Windows\\System32\\vcruntime140_1.dll");
//			 	System.load("C:\\Windows\\System32\\concrt140.dll");
			 
			 Path userNativeDir = Paths.get(System.getProperty("user.home"), ".sagliktest", "natives");
			 Files.createDirectories(userNativeDir);
			 
			 Path dllPath3 = userNativeDir.resolve("opencv_videoio_ffmpeg460_64.dll");

			 if (!Files.exists(dllPath3)) 
			 {
			     try (InputStream in3 = FakeMain.class.getResourceAsStream("/natives/opencv_videoio_ffmpeg460_64.dll")) 
			     {
			         Files.copy(in3, dllPath3, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }

			 System.load(dllPath3.toAbsolutePath().toString());
			
			 Path dllPath2 = userNativeDir.resolve("opencv_java460.dll");

			 if (!Files.exists(dllPath2)) 
			 {
			     try (InputStream in2 = FakeMain.class.getResourceAsStream("/natives/opencv_java460.dll")) 
			     {
			         Files.copy(in2, dllPath2, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }

			 System.load(dllPath2.toAbsolutePath().toString());
			 
			Path dllPath1 = userNativeDir.resolve("opencv_world460.dll");

			 if (!Files.exists(dllPath1)) 
			 {
			     try (InputStream in1 = FakeMain.class.getResourceAsStream("/natives/opencv_world460.dll")) 
			     {
			         Files.copy(in1, dllPath1, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }

			 System.load(dllPath1.toAbsolutePath().toString());
			 
			 
		 } 
		 else if (os.contains("mac")) 
		 {
		     // macOS
		 } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
		     // Linux / Unix
			 Path userNativeDir = Paths.get(System.getProperty("user.home"), ".sagliktest", "native");
			 Files.createDirectories(userNativeDir);

			 Path soPath = userNativeDir.resolve("libopencv_java460.so");

			 if (!Files.exists(soPath)) {
			     try (InputStream in = FakeMain.class.getResourceAsStream("/natives/libopencv_java460.so")) {
			         Files.copy(in, soPath, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }
			 
			 System.load(soPath.toAbsolutePath().toString());
			 
			 
			 
			 
			 
			 Path soPath2 = userNativeDir.resolve("libopencv_imgcodecs.so.4.6.0");

			 if (!Files.exists(soPath2)) {
			     try (InputStream in = FakeMain.class.getResourceAsStream("/natives/libopencv_imgcodecs.so.4.6.0")) 
			     {
			         Files.copy(in, soPath2, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }
			 
			 System.load(soPath2.toAbsolutePath().toString());
			 
			 
			 
			 
			 
			 Path soPath3 = userNativeDir.resolve("libopencv_imgproc.so.4.6.0");

			 if (!Files.exists(soPath3)) {
			     try (InputStream in = FakeMain.class.getResourceAsStream("/natives/libopencv_imgproc.so.4.6.0")) 
			     {
			         Files.copy(in, soPath3, StandardCopyOption.REPLACE_EXISTING);
			     }
			 }
			 
			 System.load(soPath3.toAbsolutePath().toString());
		 } 
		 else 
		 {
		     throw new RuntimeException("Desteklenmeyen işletim sistemi: " + os);
		 }
		 

	    }

}
