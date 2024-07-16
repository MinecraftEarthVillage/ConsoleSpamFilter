package earthvillage.consolespamfilter;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.ProxyReloadEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
//
//请注意！此插件带有部分中式代码！
//请注意！此插件带有部分中式代码！
//请注意！此插件带有部分中式代码！
//纯属整活！纯属整活！
//如遇异常请把它们翻译为英语                               yeee
//

public class ConsoleSpamFilter extends Plugin implements Listener {
    // 存储从配置文件中读取的要隐藏的消息关键词列表
    private List<String> messagesToHide;
    // 配置管理类实例
    private ConfigManager configManager;

    //定义一个“前缀”字符串，此时它啥也不是
private String 前缀;
    @Override
    public void onEnable() {
        // 初始化配置管理器
        configManager = new ConfigManager(this);

        前缀 = configManager.前缀();  //从隔壁配置管理器类加载前缀

        //广告👇
        System.out.println(前缀+"§r 正在启动");
        System.out.println("###################################################");
        System.out.println("#                                                 ");
        System.out.println("#       §a欢迎使用《控制台防刷屏》群组服适配版             ");
        System.out.println("#   §a地球村服务器（地址§oearthvillage.top§r§a）欢迎您         ");
        System.out.println("#                    §b官网§r                         ");
        System.out.println("#            §nhttps://emc.mysxl.cn§r                 ");
        System.out.println("#                  §bFanbook社区                     ");
        System.out.println("#         §nhttps://in.fanbook.cn/aC7VGFKB§r          ");
        System.out.println("###################################################");
        System.out.println("  ");
        System.out.println("§6请在“配置文件.yml”中按格式写入你想屏蔽的文本关键词，然后使用指令 /csfb 应用你的更改");
        //广告👆

        // 注册事件监听器
        getProxy().getPluginManager().registerListener(this, this);

        //加载配置文件
        重载配置文件();
        // 设置日志过滤器
        getProxy().getLogger().setFilter(new ConsoleLogFilter());
//注册重载指令
        getProxy().getPluginManager().registerCommand(this, new Command("csfb", "csfb.reload") {
            @Override
            public void execute(CommandSender sender, String[] args) {
                if (!sender.hasPermission("csfb.reload")){
                    sender.sendMessage(前缀+configManager.获取无权限提示文本());
                    return;
                }
                // 重新加载配置并发送确认消息给指令发送者
                重载配置文件();
                sender.sendMessage(前缀+configManager.获取重载提示文本());
            }
        });
    }

    @Override
    public void onDisable() {
        System.out.println(前缀+"§r 正在关闭");
        getProxy().getLogger().setFilter(null);
                                        //↓又是广告↓
        System.out.println("###################################################");
        System.out.println("#                                                 ");
        System.out.println("#       §a欢迎使用《控制台防刷屏》群组服适配版             ");
        System.out.println("#   §a地球村服务器（地址§oearthvillage.top§r§a）欢迎您         ");
        System.out.println("#                    §b官网§r                         ");
        System.out.println("#            §nhttps://emc.mysxl.cn§r                 ");
        System.out.println("#                  §bFanbook社区                     ");
        System.out.println("#         §nhttps://in.fanbook.cn/aC7VGFKB§r          ");
        System.out.println("###################################################");
                                        //↑又是广告↑
    }

    // 处理代理服务器重载事件
    @EventHandler
    public void onProxyReload(ProxyReloadEvent event) {
        重载配置文件();
    }

    //重载配置文件的方法（封装），可以在其他地方调用
    private void 重载配置文件() {
        configManager.reloadConfig();
        messagesToHide = configManager.获取拦截关键词们();
    }

    // 自定义的日志过滤器类
    private class ConsoleLogFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            // 使用for循环持续检查日志消息中是否包含需要隐藏的关键词，
            // 如果包含则返回 false 表示不记录该日志
            for (String filter : messagesToHide) {
                if (record.getMessage().contains(filter)) {
                    return false;
                }
            }
            //代码位招租
            //代码位招租
            //代码位招租
            //代码位招租
            //代码位招租
            //（未来更新其它处理逻辑）
            return true;
        }
    }


}
