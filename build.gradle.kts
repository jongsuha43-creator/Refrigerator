// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    //파이어베이스 연동
    //구글 서비스 추가
    id("com.google.gms.google-services") version "4.4.3" apply false

}