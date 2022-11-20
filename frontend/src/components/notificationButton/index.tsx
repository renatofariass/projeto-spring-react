import icon from "../../assets/img/notification-icon.svg";
import { BASE_URL } from "../../utils/request";
import axios from 'axios';
import "./style.css";
import { toast } from "react-toastify";

type Props = {
    saleId : number;
}

function handleClick(saleId : number) {
    axios(`${BASE_URL}/sales/notification/${saleId}`)
    .then(response => {
        toast("Sms enviado com sucesso!")
    });
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" onClick={() => handleClick(saleId)}/>
        </div>
    )

}

export default NotificationButton;
