package org.konghao.maven.hello.plugin;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Goal which touches a timestamp file.
 * @goal show
 * @phase test
 */
public class StatusFileMojo extends AbstractMojo {
	
	/**
     * @parameter expression="${project.build.directory}"
     * @required
     */
	private File dir;
	/**
	 * @paramter alias=d
	 */
	private boolean isDir=true;
	/**
	 * @parameter
	 */
	private String[] files;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		File [] fs = dir.listFiles();
		for(File f:fs) {
			if(f.isDirectory()) {
				if(isDir) {
					System.out.println(f.getName()+"--d");
				} else {
					continue;
				}
			} else {
				if(files!=null&&files.length>0) {
					for(String fn:files) {
						if(f.getName().endsWith("."+fn)) {
							System.out.println(f.getName()+"--"+(f.length()/1024)+"k");
						}
					}
				} else {
					System.out.println(f.getName()+"--"+(f.length()/1024)+"k");
				}
			}
		}
	}

}
