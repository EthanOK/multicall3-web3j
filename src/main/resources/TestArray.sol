// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract TestArray {
    struct Order {
        address from;
        address to;
    }
    struct Array {
        uint256[] addresss;
        address account;
    }
    struct ExactInputParams {
        bytes path;
        address recipient;
        uint256 amountIn;
        uint256 amountOutMinimum;
    }

    function exactInput(
        ExactInputParams calldata params
    ) external payable returns (uint256 amountOut) {}

    function setOrder(Order calldata order) external {}

    function setOrders(Order[] calldata orders) external {}

    function setOrderss(Order[][] calldata orderss) external {}

    function get(Array[] calldata arrays) external {}

    function name() external view{}
}
