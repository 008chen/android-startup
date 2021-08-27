plugins {
    `kotlin-dsl`
}

repositories {
//    jcenter()
    maven {
        url = uri("https://maven.aliyun.com/repository/gradle-plugin")
    }
    maven {
        url = uri("https://maven.aliyun.com/repository/google/")
    }
    maven { setUrl("https://jitpack.io") }
    maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
    maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/jcenter") }
    maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/google") }
    maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/gradle-plugin") }
}