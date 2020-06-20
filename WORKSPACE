workspace(name = "toms")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "io_bazel_rules_go",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/rules_go/releases/download/v0.19.5/rules_go-v0.19.5.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.19.5/rules_go-v0.19.5.tar.gz",
    ],
    sha256 = "513c12397db1bc9aa46dd62f02dd94b49a9b5d17444d49b5a04c5a89f3053c1c",
)

# gRPC v1.27.3
http_archive(
    name = "com_github_grpc_grpc",
    urls = [
        "https://github.com/grpc/grpc/archive/e73882dc0fcedab1ffe789e44ed6254819639ce3.tar.gz",
    ],
    strip_prefix = "grpc-e73882dc0fcedab1ffe789e44ed6254819639ce3",
)
load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps")
grpc_deps()

load("@com_github_grpc_grpc//bazel:grpc_extra_deps.bzl", "grpc_extra_deps")
grpc_extra_deps()

# gRPC-java v1.29.0
http_archive(
    name = "com_github_grpc_java",
    strip_prefix = "grpc-java-049b12818b87aae4df9a92fbe35540b92a653dee",
    url = "https://github.com/grpc/grpc-java/archive/049b12818b87aae4df9a92fbe35540b92a653dee.tar.gz",
    sha256 = "ec387bfb9edb6bc6dcedeb05c799f8511c6baba38182eb8ae77db000a2a1c71b",
)

# jvm external rules v3.2
http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-3.2",
    sha256 = "82262ff4223c5fda6fb7ff8bd63db8131b51b413d26eb49e3131037e79e324af",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/3.2.zip",
)
# load("@maven//:compat.bzl", "compat_repositories")
# compat_repositories()

load("@com_github_grpc_java//:repositories.bzl", "grpc_java_repositories")
grpc_java_repositories()

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@com_github_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_ARTIFACTS")
load("@com_github_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS")
maven_install(
    artifacts = [
        "junit:junit:4.12",
        "org.apache.commons:commons-lang3:3.3.2",
        "org.slf4j:log4j-over-slf4j:1.7.21",
        "org.slf4j:jul-to-slf4j:1.7.22",
        "ch.qos.logback:logback-core:1.1.7",
        "ch.qos.logback:logback-classic:1.1.7",
        "log4j:log4j:1.2.17",
        "commons-logging:commons-logging:1.1.3",
        "com.google.inject:guice:4.2.3",
        "com.esotericsoftware.yamlbeans:yamlbeans:1.13",
        "com.google.code.gson:gson:2.8.6",
    ] + IO_GRPC_GRPC_JAVA_ARTIFACTS,
    #generate_compat_repositories = True,
    fetch_sources = True,
    override_targets = IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS,
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)