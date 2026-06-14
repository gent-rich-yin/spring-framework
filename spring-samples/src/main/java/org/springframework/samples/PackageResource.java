package org.springframework.samples;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageResource {
    public static void main(String[] args) throws IOException{
        URL url_samples = Thread.currentThread().getContextClassLoader().getResource("org/springframework/samples");
        System.out.println(String.format("URL: %s", url_samples));

        URL url_jspecify = Thread.currentThread().getContextClassLoader().getResource("org/jspecify/annotations");
        System.out.println(String.format("URL: %s", url_jspecify));

        JarURLConnection con = (JarURLConnection) url_jspecify.openConnection();
        JarFile jarFile = con.getJarFile();

        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName(); // e.g., "BOOT-INF/classes/com/example/app/MyService.class"
            System.out.println(entryName);
        }
    }

}
