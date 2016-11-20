package cn.edu.gdmec.a07150847.filedemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private File fPhoneDicectory;
    private File fExternalStoragePublicDicectory;
    private File fExternalStorageDicectory;
    private File fDataStorage;
    private File fDownloadCacheDicectory;
    private File fRootDicectory;
    private String name,path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.result);
        fPhoneDicectory=this.getFilesDir();
        fExternalStoragePublicDicectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        fExternalStorageDicectory=Environment.getExternalStorageDirectory();
        fDataStorage=Environment.getDataDirectory();
        fDownloadCacheDicectory=Environment.getDownloadCacheDirectory();
        fRootDicectory=Environment.getRootDirectory();
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)){
            Button btn = (Button) findViewById(R.id.ExternalStorageDicectory);
            btn.setEnabled(false);

        }
    }

    public void phoneDicectory(View v){
        path = fPhoneDicectory.getPath();

        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            fos.write("嘿嘿".getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listFiles(path);
    }

    public void externalStoragePublicDicectory(View v){
        path=fExternalStoragePublicDicectory.getAbsolutePath();
        listFiles(path);
    }

    public void externalStorageDicectory(View v){
        path=fExternalStorageDicectory.getAbsolutePath();
        listFiles(path);
    }

    public void dataStorage(View v){
        path=fDataStorage.getAbsolutePath();
        listFiles(path);
    }

    public void downloadCacheDicectory(View v){
        path=fDownloadCacheDicectory.getAbsolutePath();
        listFiles(path);

    }

    public void rootDicectory(View v){
        path=fRootDicectory.getAbsolutePath();
        listFiles(path);
    }


    public boolean listFiles(String path){
        name="路径:"+path+"\n文件清单:\n";
        File file = new File(path);
        if(file.listFiles()!=null&&file.listFiles().length>0){
            for(File f:file.listFiles()){
                path=f.getAbsolutePath();
                name=name+f.getName()+"\n";
            }
        }
        tv1.setText(name);

        return true;
    }
}
