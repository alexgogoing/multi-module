<html lang="zh-Hans"><head><meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no,viewport-fit=cover">
<meta name="google-site-verification" content="cCHsgG9ktuCTgWgYfqCJql8AeR4gAne4DTZqztPoirE">
<meta name="apple-itunes-app" content="app-id=987739104">
<meta name="baidu-site-verification" content="qiK2a1kcFc">
<meta name="360-site-verification" content="4c3c7d57d59f0e1a308462fbc7fd7e51">
<meta name="sogou_site_verification" content="c49WUDZczQ">

<article data-v-1ca5cc54="" itemscope="itemscope" itemtype="http://schema.org/Article" class="article" data-v-7d5ab67e="">
<h1 data-v-1ca5cc54="" class="article-title">Maven多模块-Spring Boot项目</h1><div data-v-1ca5cc54="" data-id="5bfbd205f265da61407e9604" itemprop="articleBody" class="article-content"><p>在开发过程中，为了方便我们可能会将所有的代码都放在一个项目中，所有人的工作内容都集中在一起。随着业务的快速发展，会导致整个项目越来越复杂和后期维护难等问题。而项目模块化可以更好的实现代码复用，简化项目结构，使逻辑更加清晰，也方便团队分工合作，后期扩展和维护。</p>

<p>本文将以一个个人博客项目为例，简单讲解如何搭建一个基于<code>Spring Boot</code>的<code>Maven</code>多模块项目。</p>
<p>环境：</p>
<ol>
<li>JDK</li>
<li>Maven(3.3.9)</li>
<li>Intellij IDEA</li>
</ol>
<h4 class="heading" data-id="heading-0">1. 首先创建一个<code>Spring Boot</code>父项目</h4>
<p></p><figure><img alt="创建Spring Boot项目" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674f77704cd653f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="1280" data-height="904" src="https://user-gold-cdn.xitu.io/2018/11/26/1674f77704cd653f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure>
注意<code>Type</code>类型选择<code>pom</code><p></p>
<p>项目结构如下图所示</p>
<p></p><figure><img alt="项目结构" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674f785b1389edb?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="1280" data-height="773" src="https://user-gold-cdn.xitu.io/2018/11/26/1674f785b1389edb?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure>
<code>pom</code>配置文件修改成如图所示。图中标出的两个文件夹是用来存放子项目，<code>library</code>用来存放依赖的项目，<code>application</code>用来存放应用，当然也可以选择直接放在根目录。<p></p>
<h4 class="heading" data-id="heading-1">2. 创建子项目</h4>
<p>右键父项目，选择<code>New</code>，然后选择<code>Module</code>，注意选择<code>Maven</code>类型项目</p>
<p></p><figure><img alt="创建子项目" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674f79ef7abf66a?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="1280" data-height="904" src="https://user-gold-cdn.xitu.io/2018/11/26/1674f79ef7abf66a?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure>
继续下一步<p></p>
<p></p><figure><img alt="创建子项目" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674f7c3a04cb0bc?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="1280" data-height="922" src="https://user-gold-cdn.xitu.io/2018/11/26/1674f7c3a04cb0bc?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure>
这里把<code>blog-web</code>项目放在了<code>application</code>文件夹，可以选择放在根目录，没有影响。<p></p>
<p>创建好直接项目结构如下</p>
<p></p><figure><img alt="项目结构" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674fa81ede8ba9f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="1280" data-height="773" src="https://user-gold-cdn.xitu.io/2018/11/26/1674fa81ede8ba9f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure>
由于这里当前项目放在<code>application</code>文件夹内，所以<code>blog-web</code>中<code>pom</code>文件中的<code>relativePath</code>的配置如图所示。若子项目放在根目录，则配置略有不同，应该是<code>../pom.xml</code>。<p></p>
<p>修改<code>blog-web</code>的<code>pom</code>文件</p>
<pre><code class="hljs xml copyable" lang="xml"><span class="php"><span class="hljs-meta">&lt;?</span>xml version=<span class="hljs-string">"1.0"</span> encoding=<span class="hljs-string">"UTF-8"</span><span class="hljs-meta">?&gt;</span></span>
<span class="hljs-tag">&lt;<span class="hljs-name">project</span> <span class="hljs-attr">xmlns</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0"</span>
         <span class="hljs-attr">xmlns:xsi</span>=<span class="hljs-string">"http://www.w3.org/2001/XMLSchema-instance"</span>
         <span class="hljs-attr">xsi:schemaLocation</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">parent</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-multi-module<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.example<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>0.0.1-SNAPSHOT<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">relativePath</span>&gt;</span>../../pom.xml<span class="hljs-tag">&lt;/<span class="hljs-name">relativePath</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">parent</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">modelVersion</span>&gt;</span>4.0.0<span class="hljs-tag">&lt;/<span class="hljs-name">modelVersion</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>blog-web<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">dependencies</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.example<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>blog-service<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>0.0.1-SNAPSHOT<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter-web<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>

        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter-test<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependencies</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">build</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">plugins</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">plugin</span>&gt;</span>
                <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
                <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-maven-plugin<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
            <span class="hljs-tag">&lt;/<span class="hljs-name">plugin</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">plugins</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">build</span>&gt;</span>

<span class="hljs-tag">&lt;/<span class="hljs-name">project</span>&gt;</span>
<span class="copy-code-btn">复制代码</span></code></pre><p>接下来依次创建<code>service</code>和<code>dao</code>模块，具体过程就不一一解释了，流程和上面叙述的相同，主要看下每个项目的<code>pom</code>文件的配置。</p>
<p><code>blog-service</code>的<code>pom</code>文件</p>
<pre><code class="hljs xml copyable" lang="xml"><span class="php"><span class="hljs-meta">&lt;?</span>xml version=<span class="hljs-string">"1.0"</span> encoding=<span class="hljs-string">"UTF-8"</span><span class="hljs-meta">?&gt;</span></span>
<span class="hljs-tag">&lt;<span class="hljs-name">project</span> <span class="hljs-attr">xmlns</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0"</span>
         <span class="hljs-attr">xmlns:xsi</span>=<span class="hljs-string">"http://www.w3.org/2001/XMLSchema-instance"</span>
         <span class="hljs-attr">xsi:schemaLocation</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">parent</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-multi-module<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.example<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>0.0.1-SNAPSHOT<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">relativePath</span>&gt;</span>../../pom.xml<span class="hljs-tag">&lt;/<span class="hljs-name">relativePath</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">parent</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">modelVersion</span>&gt;</span>4.0.0<span class="hljs-tag">&lt;/<span class="hljs-name">modelVersion</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>blog-service<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">dependencies</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.example<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>blog-dao<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>0.0.1-SNAPSHOT<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>

        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter-test<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependencies</span>&gt;</span>

<span class="hljs-tag">&lt;/<span class="hljs-name">project</span>&gt;</span>

<span class="copy-code-btn">复制代码</span></code></pre><p><code>blog-dao</code>的<code>pom</code>文件</p>
<pre><code class="hljs xml copyable" lang="xml"><span class="php"><span class="hljs-meta">&lt;?</span>xml version=<span class="hljs-string">"1.0"</span> encoding=<span class="hljs-string">"UTF-8"</span><span class="hljs-meta">?&gt;</span></span>
<span class="hljs-tag">&lt;<span class="hljs-name">project</span> <span class="hljs-attr">xmlns</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0"</span>
         <span class="hljs-attr">xmlns:xsi</span>=<span class="hljs-string">"http://www.w3.org/2001/XMLSchema-instance"</span>
         <span class="hljs-attr">xsi:schemaLocation</span>=<span class="hljs-string">"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">parent</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-multi-module<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.example<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>0.0.1-SNAPSHOT<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">relativePath</span>&gt;</span>../../pom.xml<span class="hljs-tag">&lt;/<span class="hljs-name">relativePath</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">parent</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">modelVersion</span>&gt;</span>4.0.0<span class="hljs-tag">&lt;/<span class="hljs-name">modelVersion</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>blog-dao<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>

    <span class="hljs-tag">&lt;<span class="hljs-name">dependencies</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter-data-jpa<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>com.h2database<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>h2<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>

        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.projectlombok<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>lombok<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.springframework.boot<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
            <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>spring-boot-starter-test<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependencies</span>&gt;</span>

<span class="hljs-tag">&lt;/<span class="hljs-name">project</span>&gt;</span>
<span class="copy-code-btn">复制代码</span></code></pre><h4 class="heading" data-id="heading-2">项目成功运行！！！</h4>
<p></p><figure><img alt="成功运行" class="lazyload inited loaded" data-src="https://user-gold-cdn.xitu.io/2018/11/26/1674faa0d4fd5306?imageView2/0/w/1280/h/960/format/webp/ignore-error/1" data-width="962" data-height="770" src="https://user-gold-cdn.xitu.io/2018/11/26/1674faa0d4fd5306?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"><figcaption></figcaption></figure><p></p>
<p>注意：<code>blog-dao</code>的<code>application.yml</code>文件放在<code>classpath:config</code>下面，是为了避免配置被覆盖，导致读取不到相关配置的问题。</p>
</div></article>
</html>