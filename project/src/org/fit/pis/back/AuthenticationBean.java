package org.fit.pis.back;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AuthenticationBean
{
    private boolean authorized;
    private String login;
    private String password;
    
    public AuthenticationBean()
    {
        authorized = false;
    }

    public boolean isAuthorized()
    {
        return authorized;
    }

    public void setAuthorized(boolean authorized)
    {
        this.authorized = authorized;
    }
    
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String actionLogout()
    {
        authorized = false;
        return "/login";
    }
    
    public String actionLogin()
    {
        if (login.equals("jan") && password.equals("novak"))
        {
            authorized = true;
            return "login";
        }
        else
        {
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid login"));
            return "failed";
        }
    }
}
