package suvi.cv.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DataNotFoundExeption extends RuntimeException{
	
	public DataNotFoundExeption(Exception cause) {
		super(cause);
	}

}
