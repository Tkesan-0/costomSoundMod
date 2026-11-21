plugins {
    java
}

version = "1.0"

repositories {
    mavenCentral()
    maven("https://raw.githubusercontent.com/Zelaux/MindustryRepo/master/repository")
    maven("https://www.jitpack.io")
}

val mindustryVersion = "v154"

dependencies {
    compileOnly("com.github.Anuken.Arc:arc-core:$mindustryVersion")
    compileOnly("com.github.Anuken.Mindustry:core:$mindustryVersion")
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "17"
    targetCompatibility = "17"
    options.encoding = "UTF-8"
}

tasks.jar {
    archiveFileName.set("${project.name}.jar")
    from(*configurations.runtimeClasspath.get().files.map { if (it.isDirectory) it else zipTree(it) }.toTypedArray())
    from(rootDir) {
        include("mod.json")
    }
    from("assets/") {
        include("**")
    }
}
plugins {
    java
}

version = "1.0"

repositories {
    mavenCentral()
    maven("https://raw.githubusercontent.com/Zelaux/MindustryRepo/master/repository")
    maven("https://www.jitpack.io")
}

val mindustryVersion = "v154"
val jabelVersion = "93fde537c7"

dependencies {
    compileOnly("com.github.Anuken.Arc:arc-core:$mindustryVersion")
    compileOnly("com.github.Anuken.Mindustry:core:$mindustryVersion")
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "17"
    targetCompatibility = "17"
    options.encoding = "UTF-8"
}

tasks.jar {
    archiveFileName.set("${project.name}.jar")
    from(*configurations.runtimeClasspath.get().files.map { if (it.isDirectory) it else zipTree(it) }.toTypedArray())
    from(rootDir) {
        include("mod.json")
    }
    from("assets/") {
        include("**")
    }
}
