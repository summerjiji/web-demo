package database

import java.text.SimpleDateFormat

output = '''WVER0010I: Copyright (c) IBM Corporation 2002, 2012; All rights reserved.
WVER0012I: VersionInfo reporter V1.15.1.48，日期：2/8/12

--------------------------------------------------------------------------------
IBM WebSphere 产品安装状态报告
--------------------------------------------------------------------------------

日期和时间 2018年7月10日 上午09时47分14秒 时的报告

安装
--------------------------------------------------------------------------------
产品目录                     /opt/IBM/WebSphere/AppServer
版本目录                     /opt/IBM/WebSphere/AppServer/properties/version
DTD 目录                   /opt/IBM/WebSphere/AppServer/properties/version/dtd
日志目录                     /var/ibm/InstallationManager/logs

产品列表
--------------------------------------------------------------------------------
BASE                     已安装

已安装产品
--------------------------------------------------------------------------------
名称         IBM WebSphere Application Server
版本         8.5.5.0
标识         BASE
构建级别       gm1319.01
构建日期       5/14/13
软件包        com.ibm.websphere.DEVELOPERSILAN.v85_8.5.5000.20130514_1044
体系结构       x86-64 (64 bit)
已安装功能部件    针对 Java 的 IBM 64 位 WebSphere SDK
           WebSphere Application Server Full Profile
           用于 EJB 3.0 之前的模块的 EJBDeploy 工具
           可嵌入式 EJB 容器
           独立瘦客户机和资源适配器
可选语言       简体中文

--------------------------------------------------------------------------------
结束安装状态报告
--------------------------------------------------------------------------------
'''

weblogic='''<domain-version>9.2.2.0</domain-version>'''


rtnList = [];
if (output != null) {
    String [] lines = output.split("\\R");
    if (lines.size() > 0) {
        map = [:];
        for (String str : lines) {
            if (str.trim().startsWith("名称")) {
                String name = str.replace("名称", "").trim();
                map.put("name", name)
            }
            if (str.trim().startsWith("版本")) {
                String version = str.replace("版本", "").trim();
                map.put("version", version)
            }
            if (str.trim().startsWith("构建日期")) {
                String time = str.replace("构建日期", "").trim();
                SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yy");
                Date date = sdf.parse(time);
                long timgLong = date.getTime();
                map.put("installTime", timgLong)
            }
            map.put("vendor", "IBM");
        }
        if (map.containsKey("name") && map.get("name") != null) {
            rtnList.add(map);
        }
    }
}
if (weblogic != null) {
    if (weblogic.contains("<domain-version>")) {
        String version = weblogic.replace("<domain-version>", "").replace("</domain-version>", "").trim();
        weblogicMap = [:];
        weblogicMap.put("name", "weblogic");
        weblogicMap.put("vendor", "Oracle");
        weblogicMap.put("version", version);
        rtnList.add(weblogicMap);
    }
}
return rtnList;


