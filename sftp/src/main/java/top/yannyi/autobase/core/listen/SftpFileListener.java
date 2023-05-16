package top.yannyi.autobase.core.listen;

import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: LeahAna
 * @Date: 2023/3/31 11:21
 * @Desc: sftp文件夹监听
 */

//@Component
@Slf4j
public class SftpFileListener implements ChannelSftp.LsEntrySelector {
    @Override
    public int select(ChannelSftp.LsEntry lsEntry) {
        return 0;
    }

   /* private final String watchPath;
    //    private final String localPath=;
    private final ExecutorService executorService;
    private final Set<String> existingFiles = new ConcurrentSkipListSet<>();
    private final Consumer<String> onFileCreate;
    //  private final Consumer<String> onFileDelete;

    // @Autowired
   // private SftpTemplate sftpTemplate;


    public SftpFileListener(String watchPath,
//                            String localPath,
                            Consumer<String> onFileCreate
                            // ,Consumer<String> onFileDelete
    ) {
        // todo: 实际使用请用ThreadPoolExecutor创建线程池
        this.executorService = Executors.newCachedThreadPool();
        this.watchPath = watchPath;
//        this.localPath = localPath;
        this.onFileCreate = onFileCreate;
        //  this.onFileDelete = onFileDelete;
    }

    @Override
    public int select(ChannelSftp.LsEntry lsEntry) {
        log.info("=========lsEntry={}", lsEntry);
        String filename = lsEntry.getFilename();
        log.info("--------filename:{}", filename);
        if (filename.contains("Success")) {
            return ChannelSftp.LsEntrySelector.CONTINUE;
        }
        SftpATTRS attrs = lsEntry.getAttrs();
        log.error("attrs:{}", attrs);
        boolean reg = attrs.isReg();
        log.error("reg={}", reg);
        if (reg) {
            if (filename.endsWith("txt"))
                onFileCreate.accept(filename);
        }
        return CONTINUE;
    }


    private void add(String filename) {
        existingFiles.add(filename);
    }

    private void remove(String filename) {
        existingFiles.remove(filename);
    }
*/
}
