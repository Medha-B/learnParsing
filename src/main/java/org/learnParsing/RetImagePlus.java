package org.learnParsing;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "RetImageClass", mixinStandardHelpOptions = true, description = "Returns ImagePlus object", version = "1.0")
public class RetImagePlus implements Callable<Integer> {
	@Option(names = "-r", description = "The r option")
	String rValue;
	@Option(names = "-S", description = "The S option")
	String sValue;
	@Option(names = "-A", description = "The A file")
	File aFile;
	@Option(names = "--test", description = "The test option")
	boolean test;
	@Parameters(description = "Positional params")
	List<String> positional;

	@Override
	public Integer call() {
		System.out.printf("-r=%s%n", rValue);
		System.out.printf("-S=%s%n", sValue);
		System.out.printf("-A=%s%n", aFile);
		System.out.printf("--test=%s%n", test);
		System.out.printf("positionals=%s%n", positional);
		return 0;
	}

	public static void main(String... args) {
		System.exit(new CommandLine(new RetImagePlus()).execute(args));
	}

}
