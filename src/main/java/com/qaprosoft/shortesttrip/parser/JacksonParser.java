package com.qaprosoft.shortesttrip.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.shortesttrip.models.Country;

public class JacksonParser {

	private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	private static Logger logger = LogManager.getLogger();
	private ObjectMapper om = new ObjectMapper();

	public void writeToJson(List<Country> countries, String filePath) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		om.setDateFormat(df);
		try {
			om.writeValue(new File(filePath), countries);
		} catch (JsonGenerationException e) {
			logger.log(Level.ERROR, "Generation error", e);
		} catch (JsonMappingException e) {
			logger.log(Level.ERROR, "Object mapping error", e);
		} catch (IOException e) {
			logger.log(Level.ERROR, "File path is invalid", e);
		}
	}

	public List<Country> readFromJson(String filePath) {
		InputStream input = null;
		List<Country> countries = null;
		try {
			input = new FileInputStream(filePath);
			countries = om.readValue(input, om.getTypeFactory().constructCollectionType(List.class, Country.class));
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "File for parse not found", e);
		} catch (JsonParseException e) {
			logger.log(Level.ERROR, "Parse error", e);
		} catch (JsonMappingException e) {
			logger.log(Level.ERROR, "Object mapping error", e);
		} catch (IOException e) {
			logger.log(Level.ERROR, "File input stream error", e);
		} finally {
			IOUtils.closeQuietly(input);
		}
		return countries;
	}
}