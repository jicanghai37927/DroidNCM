package io.bunnyblue.droidncm.utils;

import android.os.Environment;
import android.text.TextUtils;


import com.yeamy.ncmdump.NcmDump;

import java.io.File;

import io.bunnyblue.droidncm.dump.NcmDumper;

public class NcmdumpUtils {

    public static String ncpDump(File file) {
        String targetFile = "";


        // try NcmDump
        if (TextUtils.isEmpty(targetFile)) {
            File outPath = new File(Environment.getExternalStorageDirectory(), "Music");
            outPath.mkdirs();

            targetFile = NcmDump.dump(file, outPath);
        }

        // try NcmDumper
        if (TextUtils.isEmpty(targetFile)) {
            targetFile = NcmDumper.ncpDump(file.getAbsolutePath());
            if (targetFile.startsWith("/")) {
                File target = new File(targetFile);
                if (!target.exists()) {
                    targetFile = "";
                }
            } else {
                targetFile = "";
            }
        }


        return targetFile;
    }
}
