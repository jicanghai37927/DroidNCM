#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>

//#include <openssl/bio.h>
//#include <openssl/evp.h>

#include <mpegfile.h>
#include <flacfile.h>
#include <attachedpictureframe.h>
#include <id3v2tag.h>
#include <tag.h>

#include "cJSON.h"
#include "io_bunnyblue_droidncm_dump_NcmDumper.h"
#include "ncmcrypt.h"

#include <stdexcept>
#include <android/log.h>

JNIEXPORT jstring JNICALL Java_io_bunnyblue_droidncm_dump_NcmDumper_ncpDump(JNIEnv *env, jclass clazz, jstring ncmPath)
{
  const char *nativeString = env->GetStringUTFChars(ncmPath, 0);
  char targetPath[1024] = {'\0'};

  try
  {
    NeteaseCrypt crypt(nativeString);
    crypt.Dump();
    crypt.FixMetadata();
    env->ReleaseStringUTFChars(ncmPath, nativeString);
    return env->NewStringUTF(crypt.dumpFilepath().c_str());


    // this executes if f() throws std::underflow_error (base class rule)
  }
  catch (const std::exception &e)
  {
     LOGE("find error %s ",e.what());
      env->ReleaseStringUTFChars(ncmPath, nativeString);
      return env->NewStringUTF(e.what());
  }


}
