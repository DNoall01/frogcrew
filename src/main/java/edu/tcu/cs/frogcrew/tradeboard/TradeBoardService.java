package edu.tcu.cs.frogcrew.tradeboard;

import edu.tcu.cs.frogcrew.user.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TradeBoardService {

    private final TradeBoardRepository tradeBoardRepository;

    public TradeBoardService(TradeBoardRepository tradeBoardRepository) {
        this.tradeBoardRepository = tradeBoardRepository;
    }
}
