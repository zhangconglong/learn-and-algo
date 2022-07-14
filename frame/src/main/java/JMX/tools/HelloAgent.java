package JMX.tools;

import JMX.demo_1.Hello;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * 通过JMX提供的工具页访问（也推荐使用Jconsole工具）
 * @see http://localhost:8082
 *
 * @author: luyi
 * time: 2022/7/14 23:44
 */
public class HelloAgent {
    public static void main(String[] args) throws JMException, Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
    }
}