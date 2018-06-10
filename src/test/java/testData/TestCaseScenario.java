package testData;

public class TestCaseScenario {
	private int id;
	private String name;
	private boolean execute;
	private String info;
	private String feature;
	private String finalDataStatus;
	private String environment;
	private String testName;
	private String testData;
	
	public TestCaseScenario(int id, String name,String testName, boolean execute, String info, String feature, String finalDataStatus, String environment,String testData) {
		super();
		this.id = id;
		this.name = name;
		this.testName=testName;
		this.execute = execute;
		this.info = info;
		this.feature = feature;
		this.finalDataStatus = finalDataStatus;
		this.environment = environment;
		this.testData=testData;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean getExecute() {
		return execute;
	}
	
    public void setExecute(boolean execute) {
        this.execute = execute;
    }

	public String getInfo() {
		return info;
	}

	public String getFeature() {
		return feature;
	}

	public String getFinalDataStatus() {
		return finalDataStatus;
	}

	public void setFinalDataStatus(String finalDataStatus) {
		this.finalDataStatus = finalDataStatus;
	}

	public String getEnvironment(){return environment;}
	public String getTestData(){
		return testData;
	}

	public String setEnvironment() {return  environment;}
	public String getTestName(){
		return testName;
	}

}
