CREATE DEFINER=`root`@`localhost` PROCEDURE `ciudad_create`(
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sCiudadParam VARCHAR(250);
    DECLARE sPaisParam VARCHAR(250);
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET sCiudadParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreCiudad')));
                SET sPaisParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombrePais')));
                
                INSERT INTO ciudad VALUES (`sCiudadParam`, `sMonumentoParam`, `sPaisParam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END