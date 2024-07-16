package earthvillage.consolespamfilter;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ConfigManager {

    private final Plugin plugin;
    private Configuration config;

    public ConfigManager(Plugin plugin) {
        this.plugin = plugin;
        reloadConfig();
    }

    public void reloadConfig() {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }
            File configFile = new File(plugin.getDataFolder(), "配置文件.yml");

            if (!configFile.exists()) {
                Files.copy(plugin.getResourceAsStream("配置文件.yml"), configFile.toPath());
            }

            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//显示变量，用于在配置文件里获取“真正的文本”
// 用来翻译
    public List<String> 获取拦截关键词们() {
        return config.getStringList("拦截关键词");
    }

    public String 获取重载提示文本() {
        return config.getString("指令反馈.重载");
    }
    public String 获取无权限提示文本() {
        return  config.getString("指令反馈.无权");
    }
    public String 前缀(){
        return config.getString("前缀","§7<§6控制台防刷屏§7>");
    }
}
