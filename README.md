### 用来屏蔽控制台的垃圾信息
<br>
**仅此而已**
<br>
仿造自ConsoleSpamFix（https://www.spigotmc.org/resources/console-spam-fix.18410/）
<br>
但我做的是适配群组服务端的<br>
有且仅有一个指令——*csfb*，重载配置文件（加个*b*也就是代表“*bungee*”，同时不与*ConsoleSpamFix*插件的*csf*指令冲突）<br>

###         使用前
<img width="1280" alt="image" src="https://github.com/user-attachments/assets/ccd06456-f02f-4b0a-9236-baca21f4e0c4">


###         使用后
<img width="1152" alt="image" src="https://github.com/user-attachments/assets/569ab9b1-00ef-4b14-91d4-ec5a449277d2">
<br>
<br>
 ### 要构建城JAR文件，请按以下步骤<br>
 1.点击左上角**文件**→项目结构→工件→ + →JAR→**来自具有依赖项的模块**，并且勾选**包含在项目构建中（B）**<br>
 <img width="626" alt="image" src="https://github.com/user-attachments/assets/3cc963c8-735b-4593-a4d7-f6903851dfbc"><br>
2.在“主类”输入框写入**earthvillage.consolespamfilter.ConsoleSpamFilter**，其余不变，按下确定<br>
![image](https://github.com/user-attachments/assets/da19bddb-c179-431b-bc8c-6e6ab3878b8f)<br>
3.JAR文件输出目录与文件名字任选，只要你能找到<br>
<img width="450" alt="image" src="https://github.com/user-attachments/assets/b71e22b7-ab5b-4e38-b60f-56b68be3a4fd"><br>
4.退回到编辑器，点击上方偏中间一点那个“锤子”，就开始生成JAR文件了<img width="873" alt="image" src="https://github.com/user-attachments/assets/2df288c6-6205-4888-b09d-cd659210093d"><br>

<br><br><br><br><br><br><br><br><br>注意：此源码包里面包含一些中式代码，如果因为非英文字母造成性能问题或BUG请手动修改源代码！
