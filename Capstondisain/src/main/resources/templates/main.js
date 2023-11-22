IMP.init("imp81265272");

const button = document.querySelector("button");

const onClickPay = async () => {
    IMP.request_pay({
        pg: "kakaopay",
        pay_method: "card",
        amount: "60000",
        name: "아이유 콘서트",
        merchant_uid: "ORD20231030-000001",
    });
};

button.addEventListener("click", onClickPay);