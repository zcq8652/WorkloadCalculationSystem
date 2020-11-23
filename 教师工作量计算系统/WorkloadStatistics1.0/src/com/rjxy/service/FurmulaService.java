package com.rjxy.service;

import com.rjxy.domain.Count;

public class FurmulaService {
	public String countService(Count count,String furmula) {
		String[] countc = {"reality","experiment","npeople","nclass","nday","ngroup","nteacher","nteam","nweekA","nweekB","result"};
		String[] countz = {String.valueOf(count.getReality()),String.valueOf(count.getExperiment()),String.valueOf(count.getNpeople()),String.valueOf(count.getNclass()),String.valueOf(count.getNday()),String.valueOf(count.getNgroup()),String.valueOf(count.getNteacher()),String.valueOf(count.getNteam()),String.valueOf(count.getNweekA()),String.valueOf(count.getNweekB()),String.valueOf(count.getResult())};
		for(int i=0;i<countc.length;i++) {
			furmula = furmula.replace(countc[i],countz[i]);
		}
		return furmula;
	}
}
