package com.repomon.rocketdan.domain.user.entity;


import com.repomon.rocketdan.domain.repo.entity.ActiveRepoEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Optional;


@Entity
@Getter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	private String userName;

	@OneToOne
	@JoinColumn(name = "represent_repo_id")
	private ActiveRepoEntity representRepo;


	public void updateRepresentRepo(ActiveRepoEntity repo) {
		this.representRepo = repo;
	}


	public Optional<ActiveRepoEntity> getRepresentRepo() {
		return Optional.ofNullable(representRepo);
	}

}
