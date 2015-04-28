package hackstreet.sixeswild.config;

import java.io.File;
import java.util.ArrayList;

public class AbstractLevelConfig {

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public ArrayList<hackstreet.sixeswild.game.Location> getNullLocations() {
		return nullLocations;
	}

	public void setNullLocations(
			ArrayList<hackstreet.sixeswild.game.Location> nullLocations) {
		this.nullLocations = nullLocations;
	}

	public double[] getPercentage() {
		return percentage;
	}

	public void setPercentage(double[] percentage) {
		this.percentage = percentage;
	}

	public int getNumShuffle() {
		return numShuffle;
	}

	public void setNumShuffle(int numShuffle) {
		this.numShuffle = numShuffle;
	}

	public int getNumSwap() {
		return numSwap;
	}

	public void setNumSwap(int numSwap) {
		this.numSwap = numSwap;
	}

	public int getNumRemove() {
		return numRemove;
	}

	public void setNumRemove(int numRemove) {
		this.numRemove = numRemove;
	}

	public int getNumHint() {
		return numHint;
	}

	public void setNumHint(int numHint) {
		this.numHint = numHint;
	}

	public double getFreq1() {
		return freq1;
	}

	public void setFreq1(double freq1) {
		this.freq1 = freq1;
	}

	public double getFreq2() {
		return freq2;
	}

	public void setFreq2(double freq2) {
		this.freq2 = freq2;
	}

	public double getFreq3() {
		return freq3;
	}

	public void setFreq3(double freq3) {
		this.freq3 = freq3;
	}

	public double getFreq4() {
		return freq4;
	}

	public void setFreq4(double freq4) {
		this.freq4 = freq4;
	}

	public double getFreq5() {
		return freq5;
	}

	public void setFreq5(double freq5) {
		this.freq5 = freq5;
	}

	public double getFreq6() {
		return freq6;
	}

	public void setFreq6(double freq6) {
		this.freq6 = freq6;
	}

	public double getFreqMult2() {
		return freqMult2;
	}

	public void setFreqMult2(double freqMult2) {
		this.freqMult2 = freqMult2;
	}

	public double getFreqMult3() {
		return freqMult3;
	}

	public void setFreqMult3(double freqMult3) {
		this.freqMult3 = freqMult3;
	}

	public int getPointsStar1() {
		return pointsStar1;
	}

	public void setPointsStar1(int pointsStar1) {
		this.pointsStar1 = pointsStar1;
	}

	public int getPointsStar2() {
		return pointsStar2;
	}

	public void setPointsStar2(int pointsStar2) {
		this.pointsStar2 = pointsStar2;
	}

	public int getPointsStar3() {
		return pointsStar3;
	}

	public void setPointsStar3(int pointsStar3) {
		this.pointsStar3 = pointsStar3;
	}

	public File getFile() {
		return File;
	}

	public void setFile(File file) {
		File = file;
	}

	protected String Type; // Added so that we can load files. It is protected b/c sub classes need to know this information;
	private String name;
	private int height;
	private int width;
	private ArrayList<hackstreet.sixeswild.game.Location> nullLocations;
	private double[] percentage = new double[6];
	private int numShuffle;
	private int numSwap;
	private int numRemove;
	private int numHint;
	private double freq1;
	private double freq2;
	private double freq3;
	private double freq4;
	private double freq5;
	private double freq6;
	private double freqMult2;
	private double freqMult3;
	private int pointsStar1;
	private int pointsStar2;
	private int pointsStar3;
	public File File;
	
	public AbstractLevelConfig(){
		
	}
}