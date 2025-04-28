package edu.tcu.cs.frogcrew.user;

import edu.tcu.cs.frogcrew.system.Result;
import edu.tcu.cs.frogcrew.system.StatusCode;
import edu.tcu.cs.frogcrew.user.converter.FrogCrewUserToFrogCrewedUserDtoConverter;
import edu.tcu.cs.frogcrew.user.converter.FrogCrewUserToUserDtoConverter;
import edu.tcu.cs.frogcrew.user.converter.FrogCrewUserToUsersDtoConverter;
import edu.tcu.cs.frogcrew.user.converter.UserDtoToFrogCrewUserConverter;
import edu.tcu.cs.frogcrew.user.dto.UserDto;
import edu.tcu.cs.frogcrew.user.dto.UsersDto;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/crewMember")
public class FrogCrewUserController {

    private final FrogCrewUserService frogCrewUserService;
    private final FrogCrewUserToUserDtoConverter frogCrewUserToUserDtoConverter;
    private final UserDtoToFrogCrewUserConverter userDtoToFrogCrewUserConverter;
    private final FrogCrewUserToUsersDtoConverter frogCrewUserToUsersDtoConverter;

    public FrogCrewUserController(FrogCrewUserService frogCrewUserService, FrogCrewUserToUserDtoConverter frogCrewUserToUserDtoConverter, UserDtoToFrogCrewUserConverter userDtoToFrogCrewUserConverter, FrogCrewUserToUsersDtoConverter frogCrewUserToUsersDtoConverter) {
        this.frogCrewUserService = frogCrewUserService;
        this.frogCrewUserToUserDtoConverter = frogCrewUserToUserDtoConverter;
        this.userDtoToFrogCrewUserConverter = userDtoToFrogCrewUserConverter;
        this.frogCrewUserToUsersDtoConverter = frogCrewUserToUsersDtoConverter;
    }

    @PostMapping
    public Result addCrewMember(@Valid @RequestBody FrogCrewUser frogCrewUser) {
        FrogCrewUser savedUser = this.frogCrewUserService.addCrewMember(frogCrewUser);
        UserDto dto = this.frogCrewUserToUserDtoConverter.convert(savedUser);
        return new Result(true, StatusCode.SUCCESS, "Add Success", dto);
    }

    @GetMapping
    public Result findCrewMembers() {
        List<FrogCrewUser> foundUsers = this.frogCrewUserService.findAll();
        List<UsersDto> dtos = foundUsers.stream().map(this.frogCrewUserToUsersDtoConverter::convert).toList();
        return new Result(true, StatusCode.SUCCESS, "Find Success", dtos);
    }

    @GetMapping("/{userId}")
    public Result findCrewMemberById(@PathVariable Integer userId) {
        FrogCrewUser foundUser = this.frogCrewUserService.findById(userId);
        UserDto dto = this.frogCrewUserToUserDtoConverter.convert(foundUser);
        return new Result(true, StatusCode.SUCCESS, "Find Success", dto);
    }

    @PutMapping("/{userId}")
    public Result updateCrewMember(@PathVariable Integer userId, @Valid @RequestBody UserDto userDto) {
        FrogCrewUser update = this.userDtoToFrogCrewUserConverter.convert(userDto);
        FrogCrewUser updatedFrogCrewUser = this.frogCrewUserService.updateCrewMember(userId, update);
        UserDto updatedDto = this.frogCrewUserToUserDtoConverter.convert(updatedFrogCrewUser);
        return new Result(true, StatusCode.SUCCESS, "Update Success", updatedDto);
    }
}
