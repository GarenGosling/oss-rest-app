package org.garen.oss.startup;

import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.service.FileTypeManage;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 初始化文件类型缓存
 *
 * @author Garen Gosling
 * @create 2017-09-16 01:59
 * @since v1.0
 */
public class InitTypeCache implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        FileTypesCache fileTypesCache = event.getApplicationContext().getBean(FileTypesCache.class);
        fileTypesCache.init();
    }
}
