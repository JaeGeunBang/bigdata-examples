package com.orienit.kalyan.examples;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class GenerateUsers {

	static final Option FILE_PATH_OPT = new Option("f", "file", true, "output file path");
	static final Option NO_OF_USERS_OPT = new Option("n", "numberOfUsers", true, "number of users");
	static final Option START_NUMBER_OPT = new Option("s", "startNumber", true, "starting number of userid, bydefault is 1");
	static final Option DELIMITER_OPT = new Option("d", "delimiter", true, "Field Delimiter, bydefault is json format");
	static final Option HELP_OPT = new Option("h", "help", false, "Show this help and quit");

	public static Options getOptions() {
		Options options = new Options();
		options.addOption(FILE_PATH_OPT);
		options.addOption(NO_OF_USERS_OPT);
		options.addOption(START_NUMBER_OPT);
		options.addOption(DELIMITER_OPT);
		options.addOption(HELP_OPT);
		return options;
	}

	public static CommandLine parseOptions(String[] args) {

		Options options = getOptions();

		CommandLineParser parser = new PosixParser();
		CommandLine cmdLine = null;
		try {
			cmdLine = parser.parse(options, args);
		} catch (ParseException e) {
			printHelpAndExit("Error parsing command line options: " + e.getMessage(), options);
		}

		if (cmdLine.hasOption(HELP_OPT.getOpt())) {
			printHelpAndExit(options, 0);
		}

		if (!cmdLine.hasOption(FILE_PATH_OPT.getOpt())) {
			throw new IllegalStateException(FILE_PATH_OPT.getLongOpt() + " is a mandatory " + "parameter");
		}

		if (!cmdLine.hasOption(NO_OF_USERS_OPT.getOpt())) {
			throw new IllegalStateException(NO_OF_USERS_OPT.getLongOpt() + " is a mandatory " + "parameter");
		}

		if (!cmdLine.getArgList().isEmpty()) {
			throw new IllegalStateException("Got unexpected extra parameters: " + cmdLine.getArgList());
		}

		return cmdLine;
	}

	public static void printHelpAndExit(String errorMessage, Options options) {
		System.err.println(errorMessage);
		printHelpAndExit(options, 1);
	}

	public static void printHelpAndExit(Options options, int exitCode) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("help", options);
		System.exit(exitCode);
	}

	public static void main(String[] args) throws IOException {

		CommandLine cmdLine = null;
		try {
			cmdLine = parseOptions(args);
		} catch (IllegalStateException e) {
			printHelpAndExit(e.getMessage(), getOptions());
		}

		String path = cmdLine.getOptionValue(FILE_PATH_OPT.getOpt());
		String numberOfUsersOpt = cmdLine.getOptionValue(NO_OF_USERS_OPT.getOpt());
		String startNumberOpt = cmdLine.getOptionValue(START_NUMBER_OPT.getOpt());
		String delimiterOpt = cmdLine.getOptionValue(DELIMITER_OPT.getOpt());

		if (delimiterOpt == null) {
			System.out.println("Bydefault data type is json .. To change the use delimiter option");
		}

		int startNumber = 1;
		if (startNumberOpt != null) {
			startNumber = Integer.parseInt(startNumberOpt);
		}

		int numberOfUsers = Integer.parseInt(numberOfUsersOpt);
		if (numberOfUsers > 10000) {
			System.err.println("Maximum number of users allowed is 10000");
			System.exit(0);
		}

		System.out.println("============================ Users Started =================================");

		KalyanUtils.generateUsers(path, startNumber, numberOfUsers, delimiterOpt, 100);

		System.out.println("============================ Users Ended  =================================");

	}

}
