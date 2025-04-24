package edu.tcu.cs.frogcrew.tradeboard;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import edu.tcu.cs.frogcrew.user.FrogCrewUser;
import edu.tcu.cs.frogcrew.user.FrogCrewUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TradeBoardService {

    private final TradeBoardRepository tradeBoardRepository;
    private final FrogCrewUserRepository userRepository;

    public TradeBoardService(TradeBoardRepository tradeBoardRepository, FrogCrewUserRepository userRepository) {
        this.tradeBoardRepository = tradeBoardRepository;
        this.userRepository = userRepository;
    }

    public TradeBoard saveTradeBoard(TradeBoard tradeBoard) {
        return tradeBoardRepository.save(tradeBoard);
    }

    public TradeBoard requestPickupGame(Integer tradeId, Integer userId) {
        TradeBoard trade = tradeBoardRepository.findById(tradeId).orElseThrow(() -> new ObjectNotFoundException("trade board", tradeId));
        FrogCrewUser user = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user", userId));

        if (trade.getDropper().getId().equals(user.getId())) throw new IllegalArgumentException("User cannot pick up their own trade");
        trade.setReceiver(user);
        trade.setStatus("awaiting approval");
        return tradeBoardRepository.save(trade);
    }

    public TradeBoard approveShiftSwap(Integer tradeId) {
        TradeBoard tradeBoard = this.tradeBoardRepository.findById(tradeId).orElseThrow(() -> new ObjectNotFoundException("trade board", tradeId));
        if (!"awaiting approval".equalsIgnoreCase(tradeBoard.getStatus())) throw new IllegalArgumentException("Cannot approve trade not currently awaiting approval.");
        tradeBoard.setStatus("approved");
        return tradeBoardRepository.save(tradeBoard);
    }

    public TradeBoard rejectShiftSwap(Integer tradeId) {
        TradeBoard tradeBoard = this.tradeBoardRepository.findById(tradeId).orElseThrow(() -> new ObjectNotFoundException("trade board", tradeId));
        if (!"awaiting approval".equalsIgnoreCase(tradeBoard.getStatus())) throw new IllegalArgumentException("Cannot reject trade not currently awaiting approval.");
        tradeBoard.setStatus("rejected");
        return tradeBoardRepository.save(tradeBoard);
    }

    public List<TradeBoard> findAll() {
        return this.tradeBoardRepository.findAll();
    }

    public List<Game> findScheduledGamesByUserId(Integer userId) {
        return null;
    }

}
