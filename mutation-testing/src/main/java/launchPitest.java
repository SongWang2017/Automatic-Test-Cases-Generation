//package MuTesting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import org.python.util.PythonInterpreter;
  
public class launchPitest {  
    
  
    private static PythonInterpreter interpreter;
    public static long count = 0;

	public static void launch() {  
		count++;
        //String commandStr = "java -cp &lt;your classpath including pit jar and dependencies&gt; \\  org.pitest.mutationtest.commandline.MutationCoverageReport \\  --reportDir c:\\mutationReports \\  --targetClasses MuTestingFinal.TestCase.Sample \\  --targetTests MuTeatingFinal.TestCase.SampleTest  --sourceDirs C:\\Users\\wangsong\\workspace\\MuTestingFinal\\src\\TestCase"; 
        //String commandStr = "cd C:\\Users\\wangsong\\workspace\\MuTestingFinal";//+ " mvn org.pitest:pitest-maven:mutationCoverage";
        //String commandStr = "ipconfig";
    	
interpreter = new PythonInterpreter();
        interpreter.execfile("C:\\Users\\wangsong\\workspace\\mutation-testing\\src\\main\\java\\runningCMD.py");
//    	PythonInterpreter interpreter = new PythonInterpreter();  
//    	interpreter.exec("import os");  
//        interpreter.exec("os.system(""cd C:\\Users\\wangsong\\workspace\\MuTestingFinal""));
//        interpreter.exec("os.system(""mvn org.pitest:pitest-maven:mutationCoverage""));
    }  
    
//    public static void exeCmd(String commandStr) {  
//        BufferedReader br = null;  
//        try {  
//            Process p = Runtime.getRuntime().exec(commandStr);  
//            br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
//            String line = null;  
//            StringBuilder sb = new StringBuilder();  
//            while ((line = br.readLine()) != null) {  
//                sb.append(line + "\n");  
//            }  
//            System.out.println(sb.toString());  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }   
//        finally  
//        {  
//            if (br != null)  
//            {  
//                try {  
//                    br.close();  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//    }  
}  