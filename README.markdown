# SAE Spring Project Template

这是一个用于SAE的Java环境的项目模版，使用Maven作为构建工具，集成了 sae-local.jar

## 配置

### pom.xml

修改你的项目的 groupId 和 artifactId：

	<groupId>your.group.id</groupId>
	<artifactId>your.artifactId</artifactId>
	<packaging>war</packaging>
	<version>1.0-SNAPSHOT</version>

修改打包文件的名称：

	<build>
		<finalName>your.app.name</finalName>
		...
	</build>

### 数据库连接

修改 `/META-INF/spring/applicationContextProd.xml` 中的线上环境的数据库连接参数：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:jdbc="http://www.springframework.org/schema/jdbc"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd"
           profile="prod">
        <bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
            <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_appname?useUnicode=yes&amp;characterEncoding=UTF-8"/>
            <property name="username" value="应用的accesskey"/>
            <property name="password" value="应用的secretkey"/>
            <property name="testOnBorrow" value="true"/>
            <property name="testOnReturn" value="true"/>
            <property name="testWhileIdle" value="true"/>
            <property name="timeBetweenEvictionRunsMillis" value="1800000"/>
            <property name="numTestsPerEvictionRun" value="3"/>
            <property name="minEvictableIdleTimeMillis" value="1800000"/>
            <property name="validationQuery" value="SELECT 1"/>
        </bean>
    </beans>

修改 `/META-INF/spring/applicationContextDev.xml` 中的本地开发环境的数据库连接参数：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:jdbc="http://www.springframework.org/schema/jdbc"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd"
           profile="dev">
        <bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
            <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/quickstart?useUnicode=yes&amp;characterEncoding=UTF-8"/>
            <property name="username" value="root"/>
            <property name="password" value=""/>
            <property name="testOnBorrow" value="true"/>
            <property name="testOnReturn" value="true"/>
            <property name="testWhileIdle" value="true"/>
            <property name="timeBetweenEvictionRunsMillis" value="1800000"/>
            <property name="numTestsPerEvictionRun" value="3"/>
            <property name="minEvictableIdleTimeMillis" value="1800000"/>
            <property name="validationQuery" value="SELECT 1"/>
        </bean>
    </beans>

### 修改项目代码的 `package`

修改了你的代码的package之后，还需要修改Spring配置文件中的扫描路径，

/META-INF/spring/applicationContext.xml

    <context:component-scan base-package="your.core.package" />

/WEB-INF/spring/servlet-context.xml

    <context:component-scan base-package="your.web.package" />

## 在本地调试项目

执行Maven的Jetty Plugin：

    mvn jetty:run
