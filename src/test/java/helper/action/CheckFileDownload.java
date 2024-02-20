package helper.action;


import org.testng.Assert;

import java.io.File;

public class CheckFileDownload {
    public static boolean isFileDownloaded(String downloadPath, String fileName) throws Exception {
        Thread.sleep(3000);

        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                Assert.assertTrue(true, "Unable to download ...");
                return true;
            }
        }
        return false;
    }
}
