FROM ubuntu:latest

MAINTAINER eddie_lys

#更新软件源
RUN apt-get update
#安装字体支持
RUN apt-get install fontconfig -y
RUN apt-get install -y language-pack-zh-hans
RUN locale-gen zh_CN.UTF-8
#清理缓存
RUN apt-get clean

RUN echo "Asia/Shanghai" > /etc/timezone

ENV JAVA_HOME /usr/local/java17/jdk-17.0.4.1
ENV PATH $JAVA_HOME/bin:$PATH

ENV LANG zh_CN.utf8

RUN mkdir /usr/local/java17
ADD jdk-17_linux-x64_bin.tar.gz /usr/local/java17

# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas