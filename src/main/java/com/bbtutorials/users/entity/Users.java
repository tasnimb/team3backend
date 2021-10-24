package com.bbtutorials.users.entity;

// import java.util.Collection;
// import java.util.Collections;

// import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import lombok.Builder;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @Builder
// @EqualsAndHashCode
// @NoArgsConstructor
@Entity(name = "Users")
@Data
public class Users /*implements UserDetails*/ {
	
	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message="{NotNull.User.firstName}")
    private String firstName;
    
    @Column
    @NotNull(message="{NotNull.User.lastName}")
    private String lastName;
    
    @Column
    @NotNull(message="{NotNull.User.email}")
    private String email;

    // @Column
    // @NotNull(message = "{NotNull.User.password")
    // private String password;

    // @Builder.Default
    // private UserRole userRole = UserRole.USER;

    // @Builder.Default
    // private Boolean locked = false;

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities(){
    //     final SimpleGrantedAuthority simpleGrantedAuthority =  new SimpleGrantedAuthority(userRole.name());
    //     return Collections.singleton(simpleGrantedAuthority);
    // }

}
