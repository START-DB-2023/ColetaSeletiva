import { TagNews } from '../TagNews/TagNews';
import './CardNews.css';

// interface PropsCard{

// }

export function CardNews() {

    return(
        <div className='cardNews'>
            <img src='./NewsCard/LixUtil.jpg' alt=''/>
            <div className='newsInfo'>
                <h5 className='localInfo'>LixUtil</h5>
                <h2 className='titleInfo'>Atualização de Cadastro de Pontos de Coleta</h2>
                <div className='tagInfo'>
                    <TagNews tag='Comunidade' color='#4B72FF'/>
                </div>
            </div>
        </div>
    );
}