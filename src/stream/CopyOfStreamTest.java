package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CopyOfStreamTest {			  // 程序入口  
			    public static void main(String[] args) {  
			        String path = "d:/read.txt";  
			        File file = new File(path);  
			   
			        // 创建输入流  
			        InputStream is;  
			        try {  
			            is = new FileInputStream(file);  
			        } catch (FileNotFoundException e) {  
			            System.err.println("文件 " + path + " 不存在。");  
			            return;  
			        }  
			   
			        // 开始读取  
			        byte[] content = new byte[0];       // 保存读取出来的文件内容  
			        byte[] buffer = new byte[10240];    // 定义缓存  
			   
			        try {  
			            int eachTime = is.read(buffer); // 第一次读取。如果返回值为 -1 就表示没有内容可读了。  
			            while (eachTime != -1) {  
			                // 读取出来的内容放在 buffer 中，现在将其合并到 content。  
			                content = concatByteArrays(content, buffer, eachTime);  
			                eachTime = is.read(buffer); // 继续读取  
			            }  
			        } catch (IOException e) {  
			            System.err.println("读取文件内容失败。");  
			            e.printStackTrace();  
			        } finally {  
			            try {  
			                is.close();  
			            } catch (IOException e) {  
			                // 这里的异常可以忽略不处理  
			            }  
			        }  
			   
			        // 输出文件内容  
			        String contentStr = new String(content);  
			        System.out.println(contentStr);  
			    }  
			   
			    /** 
			     * 合并两个字节串 
			     * 
			     * @param bytes1       字节串1 
			     * @param bytes2       字节串2 
			     * @param sizeOfBytes2 需要从 bytes2 中取出的长度 
			     * 
			     * @return bytes1 和 bytes2 中的前 sizeOfBytes2 个字节合并后的结果 
			     */  
			    private static byte[] concatByteArrays(byte[] bytes1, byte[] bytes2, int sizeOfBytes2) {  
			        byte[] result = Arrays.copyOf(bytes1, (bytes1.length + sizeOfBytes2));  
			        System.arraycopy(bytes2, 0, result, bytes1.length, sizeOfBytes2);  
			        return result;  
			    }  
}
