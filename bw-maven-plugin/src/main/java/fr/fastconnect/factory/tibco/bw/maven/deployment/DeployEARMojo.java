/**
 * (C) Copyright 2011-2015 FastConnect SAS
 * (http://www.fastconnect.fr/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.fastconnect.factory.tibco.bw.maven.deployment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 
 * <p>
 * This goal deploys a TIBCO BusinessWorks application to a TIBCO domain.
 * </p>
 * 
 * @author Mathieu Debove
 * 
 */
@Mojo( name="deploy-bw",
defaultPhase=LifecyclePhase.DEPLOY ) // FIXME: should be deployEAR
@Execute ( goal="deploy-bw", lifecycle="deploy")
public class DeployEARMojo extends AbstractBWDeployMojo {

	protected final static String DEPLOY_EAR_FAILED = "The deployment of the application failed.";
	protected final static String DEPLOYING_APPLICATION = "Deploying application to ";
	protected final static String DEPLOYING_ON_DOMAIN = " on domain ";

	protected final static String USING_EAR = "Using EAR : ";
	protected final static String USING_XML = "Using XML : ";

	@Parameter
	private boolean redeploy;
	
	/**
	 * If true, the successfully deployed service instances won't be started.
	 * Default is false.
	 */
	@Parameter ( property = "deploy.nostart", defaultValue = "false")
	private boolean noStart;

	/**
	 * If true, the service instances running before deployment won't be stopped.
	 * Default is false.
	 */
	@Parameter ( property = "deploy.nostop", defaultValue = "false")
	private boolean noStop;
	
	/**
	 * If true, deploy service instances one at a time instead of in parallel.
	 * Default is true.
	 */
	@Parameter ( property = "deploy.serialize", defaultValue = "true")
	private boolean serialize;
	
	@Parameter
	private File deployConfigXML;
	
	private void deployEAR() throws MojoExecutionException, IOException {
		checkAppManage();
		
		File ear = getOutputFile();
		getLog().info(DEPLOYING_APPLICATION + "'" + deployedProjectName + "'" +  DEPLOYING_ON_DOMAIN + "'" +  domainName+ "'");
		getLog().info(USING_EAR + ear.getAbsolutePath());
		getLog().info(USING_XML + deploymentDescriptorFinal.getAbsolutePath());
		

		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("-deploy");
		arguments.add("-ear");
		arguments.add(ear.getAbsolutePath());
		arguments.add("-deployConfig");
		arguments.add(deploymentDescriptorFinal.getAbsolutePath());
		arguments.add("-app");
		arguments.add(deployedProjectName);
		arguments.add("-domain");
		arguments.add(domainName);
		arguments.add("-user");
		arguments.add(domainUsername);
		arguments.add("-pw");
		arguments.add(domainPassword);
		if (serialize) {
			arguments.add("-serialize");
		}
		if (noStart) {
			arguments.add("-nostart");
		}
		if (noStop) {
			arguments.add("-nostop");
		}
		arguments.add("-force");

		ArrayList<File> tras = new ArrayList<File>();
		tras.add(tibcoAppManageTRAPath);

		launchTIBCOBinary(tibcoAppManagePath, tras, arguments, directory, DEPLOY_EAR_FAILED);
	}
	
	public void execute() throws MojoExecutionException {
		if (super.skip()) {
			return;
		}
		try {
			deployEAR();
		} catch (IOException e) {
			throw new MojoExecutionException(DEPLOY_EAR_FAILED, e);
		}
	}

}
