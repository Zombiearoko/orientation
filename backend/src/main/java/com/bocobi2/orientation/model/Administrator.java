<<<<<<< HEAD:backend/src/main/java/com/bocobi2/orientation/model/Administrator.java
package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrator")
public class Administrator {

    @Id
    public String AdministratorId;

    private String login;
    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

    public Administrator() {}

    public Administrator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Administratoristrator[id=%s, password='%s', password='%s']",
                AdministratorId, login, password);
    }

=======
package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrator")
public class Administrator {

    @Id
    public String AdministratorId;
    private String login;
    private String password;
    
    
    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

    public Administrator() {}

    public Administrator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"AdministratoristratorId\":%s, \"login\":'%s', \"password\":'%s'}",
                AdministratorId, login, password);
    }


>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0:backend/src/main/java/com/bocobi2/orientation/model/Administrator.java
}