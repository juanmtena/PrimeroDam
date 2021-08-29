package controllers;

import java.sql.*;
import java.util.*;

public interface IController {
    public final String PATH = "C:/Users/JuanLoreLeo/Desktop/ProyectoFinal";
    public final String CONFIG_URL = PATH + "/src/config/config.txt";

    public boolean init() throws Exception;

    public Map<String, String> getPropertiesDb() throws Exception;

    public Connection connectDb() throws Exception;

}
