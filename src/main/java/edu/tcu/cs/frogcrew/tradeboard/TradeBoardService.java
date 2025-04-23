package edu.tcu.cs.frogcrew.tradeboard;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import edu.tcu.cs.frogcrew.tradeboard.dto.TradeBoardDto;
import edu.tcu.cs.frogcrew.user.User;
import edu.tcu.cs.frogcrew.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TradeBoardService {

    private final TradeBoardRepository tradeBoardRepository;
    private final UserRepository userRepository;

    public TradeBoardService(TradeBoardRepository tradeBoardRepository, UserRepository userRepository) {
        this.tradeBoardRepository = tradeBoardRepository;
        this.userRepository = userRepository;
    }

    public TradeBoard saveTradeBoard(TradeBoard tradeBoard) {
        return tradeBoardRepository.save(tradeBoard);
    }

    public TradeBoard requestPickupGame(Integer tradeId, Integer userId) {
        TradeBoard trade = tradeBoardRepository.findById(tradeId).orElseThrow(() -> new ObjectNotFoundException("trade board", tradeId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user", userId));

        if (trade.getDropper().getId().equals(user.getId())) throw new IllegalArgumentException("User cannot pick up their own trade");
        trade.setReceiver(user);
        trade.setStatus("awaiting approval");
        return tradeBoardRepository.save(trade);
    }

    public TradeBoard approveShiftSwap(Integer tradeId, TradeBoardDto tradeBoardDto) {
        return null;
    }

    public TradeBoard rejectShiftSwap(Integer tradeId, TradeBoardDto tradeBoardDto) {
        return null;
    }

    public List<TradeBoard> findAll() {
        return this.tradeBoardRepository.findAll();
    }

    public List<Game> findScheduledGamesByUserId(Integer userId) {
        return null;
    }

}
