package edu.tcu.cs.frogcrew.tradeboard;

import edu.tcu.cs.frogcrew.system.Result;
import edu.tcu.cs.frogcrew.system.StatusCode;
import edu.tcu.cs.frogcrew.tradeboard.converter.TradeBoardDtoToTradeBoardConverter;
import edu.tcu.cs.frogcrew.tradeboard.converter.TradeBoardToTradeBoardDtoConverter;
import edu.tcu.cs.frogcrew.tradeboard.dto.TradeBoardDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.endpoint.base-url}/scheduledGames")
public class TradeBoardController {

    private final TradeBoardService tradeBoardService;
    private final TradeBoardToTradeBoardDtoConverter tradeBoardToTradeBoardDtoConverter;
    private final TradeBoardDtoToTradeBoardConverter tradeBoardDtoToTradeBoardConverter;

    public TradeBoardController(TradeBoardService tradeBoardService, TradeBoardToTradeBoardDtoConverter tradeBoardToTradeBoardDtoConverter, TradeBoardDtoToTradeBoardConverter tradeBoardDtoToTradeBoardConverter) {
        this.tradeBoardService = tradeBoardService;
        this.tradeBoardToTradeBoardDtoConverter = tradeBoardToTradeBoardDtoConverter;
        this.tradeBoardDtoToTradeBoardConverter = tradeBoardDtoToTradeBoardConverter;
    }

    @PostMapping("/drop")
    public Result addShiftToTradeBoard(@RequestBody final TradeBoardDto tradeBoardDto) {
        return null;
    }

    @PutMapping("/pickup/{tradeId}/{userId}")
    public Result pickUpTradeBoard(@PathVariable final Integer tradeId, @PathVariable final Integer userId) {
        TradeBoard tradeBoard = this.tradeBoardService.requestPickupGame(tradeId, userId);
        TradeBoardDto tradeBoardDto = this.tradeBoardToTradeBoardDtoConverter.convert(tradeBoard);
        return new Result(true, StatusCode.SUCCESS, "Request Success", tradeBoardDto);
    }

    @PutMapping("/approve/{tradeId}")
    public Result approveShiftSwap(@PathVariable final Integer tradeId) {
        return null;
    }

    @PutMapping("/deny/{tradeId}")
    public Result denyShiftSwap(@PathVariable final Integer tradeId) {
        return null;
    }

    @GetMapping("/tradeboard")
    public Result findAllTradeBoards() {
        return null;
    }

    @GetMapping("/get/{userId}")
    public Result findGamesByUserId(@PathVariable final Integer userId) {
        return null;
    }

}
