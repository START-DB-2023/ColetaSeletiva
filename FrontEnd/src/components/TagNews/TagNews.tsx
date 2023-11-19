import './TagNews.css'

interface PropsTag {
    tag:string,
    color:string,
}

export function TagNews(props:PropsTag) {
    const tagColor = props.color;
    return (
        <button className='tag' style={{background:tagColor}}>{props.tag}</button>
    );
}