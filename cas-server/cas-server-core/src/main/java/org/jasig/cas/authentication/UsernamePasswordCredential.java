/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.authentication;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Credential for authenticating with a username and password.
 *
 * @author Scott Battaglia
 * @author Marvin S. Addison
 * @since 3.0.0
 */
public class UsernamePasswordCredential implements Credential, Serializable {

    /** Authentication attribute name for password. **/
    public static final String AUTHENTICATION_ATTRIBUTE_PASSWORD = "credential";

    /** Unique ID for serialization. */
    private static final long serialVersionUID = -700605081472810939L;

    /** The username. */
    @NotNull
    @Size(min=1, message = "required.username")
    private String username;

    /** The password. */
    @NotNull
    @Size(min=1, message = "required.password")
    private String password;
    
    /** The imgverifycode. */
    //@NotNull
    @Size(min = 1, message = "required.imgverifycode")
    private String imgverifycode;
    
    private String code;
    private String name;
    private String companyid;
    private String companyname;
    private String COMPANY_SHORT_NAME;
    private String company_address;
    private String phone;
    private String user_id;

    /** Default constructor. */
    public UsernamePasswordCredential() {}

    /**
     * Creates a new instance with the given username and password.
     *
     * @param userName Non-null user name.
     * @param password Non-null password.
     */
    public UsernamePasswordCredential(final String userName, final String password,final String imgverifycode) {
        this.username = userName;
        this.password = password;
        this.imgverifycode = imgverifycode;
    }

    /**
     * @return Returns the password.
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * @param password The password to set.
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return Returns the userName.
     */
    public final String getUsername() {
        return this.username;
    }

    /**
     * @param userName The userName to set.
     */
    public final void setUsername(final String userName) {
        this.username = userName;
    }
    
    /**
     * @return Returns the imgverifycode.
     */
    public final String getImgverifycode() {
        return this.imgverifycode;
    }

    /**
     * @param imgverifycode The imgverifycode to set.
     */
    public final void setImgverifycode(final String imgverifycode) {
        this.imgverifycode = imgverifycode;
    }
    
    public final String getCode() {
        return this.code;
    }
    public final void setCode(final String code) {
        this.code = code;
    }
    
    public final String getName() {
		return this.name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getCompanyid() {
		return this.companyid;
	}

	public final void setCompanyid(final String companyid) {
		this.companyid = companyid;
	}

	public final String getCompanyname() {
		return this.companyname;
	}

	public final void setCompanyname(final String companyname) {
		this.companyname = companyname;
	}

	public final String getCOMPANY_SHORT_NAME() {
		return this.COMPANY_SHORT_NAME;
	}

	public final void setCOMPANY_SHORT_NAME(final String COMPANY_SHORT_NAME) {
		this.COMPANY_SHORT_NAME = COMPANY_SHORT_NAME;
	}

	public final String getCompany_address() {
		return company_address;
	}

	public final void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getUser_id() {
		return user_id;
	}

	public final void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return this.username;
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final UsernamePasswordCredential that = (UsernamePasswordCredential) o;

        if (password != null ? !password.equals(that.password) : that.password != null) {
            return false;
        }

        if (username != null ? !username.equals(that.username) : that.username != null) {
            return false;
        }
        
        if (imgverifycode != null ? !imgverifycode.equals(that.imgverifycode)
                : that.imgverifycode != null)
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(username)
                .append(password)
                .append(imgverifycode)
                .toHashCode();
    }

}
