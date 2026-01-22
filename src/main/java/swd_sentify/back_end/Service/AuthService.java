package swd_sentify.back_end.Service;

import swd_sentify.back_end.DTO.RegisterRequest;
import swd_sentify.back_end.Entity.User;

public interface AuthService {
    User register(RegisterRequest request);
}
