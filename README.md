DownloadUITest
==============
使用APPIUM和JUnit框架，对小米合作下载管理项目进行UI自动化测试，目前已完成第一阶段。<br>
第一阶段已实现功能有：<br>
　　下载基本功能自动化测试<br>
　　用例运行中各阶段日志输出，运行失败时自动截图，便于分析问题<br>
　　用例运行失败或出错时自动重试（可设定重试次数），以消除UI自动化测试中常见的虚假失败情况<br>
目前存在且暂时无法解决的问题如下：<br>
　　脚本运行速度偏慢：这个是由于APPIUM的机制导致的，有时会造成下载任务验证出错（从一个来源添加完下载任务，再启动下载管理来验证时，可能这个任务已经下完了，此时找不到下载任务了，就会报错）。目前只能通过尽量构建比较大的下载数据来避免<br>
　　在浏览器中的所有点击操作只能通过屏幕坐标来点击：这个是MIUI浏览器的问题，在原生chrome下面就OK。现在也没有办法解决，只能通过坐标，导致用例的稳定性和后续维护可能会有比较多的问题<br>
　　虚假失败：比如脚本运行过程中自己找不到某个按钮之类的，这也是UI自动化测试工具的通病，一般出现几率较低，目前通过重试机制来规避<br>

=========================================================
测试用例已覆盖：<br>
1   从五大来源（应用市场、游戏中心、主题商店、音乐、浏览器）建立单个下载任务，并验证下载状态（SingleTaskTest）<br>
2   每个来源建立多个下载任务，并验证每个来源只同时运行2个下载线程（MultiTaskTest）<br>
3   单个任务、多个任务重复暂停续传时，验证下载状态（TaskPauseTest）<br>
4   从浏览器百度网盘测试下载常用文件类型（mp3、jpg、txt等）（fileTypeTest）<br>

=========================================================
使用说明：<br>
1   本机配置好java开发环境（jdk、eclipse等）<br>
2   从github下载项目代码并导入eclipse，将lib文件夹中的jar包添加至项目依赖，并添加junit4依赖<br>
3   从http://appium.io/ 官网下载最新的appium客户端（appium.exe/.dmg）<br>
4   插上已刷好测试环境的手机，运行appium客户端，并点击右上角的Launch按钮，看到界面上开始有日志刷新即表示appium启动成功<br>
5   编译运行src/com.xunlei.test.testcase包内的Junit测试用例即可<br>

注意事项：<br>
　　测试开始前，必须先使用特定的小米帐号登录手机（zml0909@163.com，abcd1234）<br>
　　测试浏览器下载时，需使用特定帐号登录百度网盘（kaworu228@qq.com，abc1234），并将百度网盘首页添加到浏览器首页`常用访问列表的第一位`<br>
　　用例运行过程中如果手动停止了，再运行之前必须在appium中点击Stop，再重新Launch，再运行用例（释放APPIUM 4723端口的机制，有兴趣的话可深入了解）<br>

=========================================================
后续计划：<br>
　　拆分测试点，补充完善更多测试用例，提高checklist覆盖率；实现测试报告的生成；定时任务、持续集成等<br>

相关测试脚本的写法请参照各case类，应该比较浅显易懂了，注释写的挺多:)<br>
源码中的具体功能模块也不复杂，使用过程中如有问题可以直接联系peiyu
