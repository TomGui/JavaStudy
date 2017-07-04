# 一、打开idea，File->New->Project。选择Mavne，勾选Create from archtype，选择org.apache.maven.archtypes:maven-archtype-webapp，点击Next。
![](http://img.blog.csdn.net/20161022112702411?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
# 二、填写这个maven项目的GroupId、ArtifactId、Version信息。这是标识maven项目的三维坐标。点击Next
![](http://img.blog.csdn.net/20161022112857740?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
# 三、下面的是一些属性，除了已有的6个，我们需要添加一个archetypeCatalog=internal。这个参数的意义是让这个maven项目的骨架不要到远程下载而是本地获取。如果你没加这个参数，那么项目创建可能在卡在downloading maven plugins...继续点击Next
![](http://img.blog.csdn.net/20161022113157819?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
# 四、为项目命名，点击Finish，项目一瞬间就创建好了！
![](http://img.blog.csdn.net/20161022113838525?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
# 五、查看项目的结构
![](http://img.blog.csdn.net/20161022114522387?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
# 六、pom.xml添加依赖
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.2</version>
        <scope>provided</scope>
    </dependency>
**需要注意的是scope都要设置为provided，因为接下来使用maven-tomcat容器运行，这2个组件tomcat中已存在，所以不需要打包**
# 七、pom.xml添加bulid-plugins
    <plugins>
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <port>8080</port>
                <charset>${project.build.sourceEncoding}</charset>
                <server>tomcat7</server>
            </configuration>
        </plugin>
    </plugins>
# 八、编译
命令：mvn compile
# 九、打包
命令：mvn package
# 十、运行
命令：mvn tomcat7:run

![运行成功](http://www.i-shenhao.com/mdp/first-mvn-webapp/tomcat-run-success.png)

# 十一、异常现象
**1.如果使用命令(mvn tomcat:run)运行，打开网站报错**

![报错信息](http://www.i-shenhao.com/mdp/first-mvn-webapp/tomcat-run-error.png)

**2.pom.xml不设置bulid-plugins，不指定tomcat版本为7，运行也报错，默认运行的是tomcat6，这个哪个高手解释下，是不是tomcat版本低了**

![tomcat6报错](http://www.i-shenhao.com/mdp/first-mvn-webapp/default-tomcat-run-error.png)
