from django.shortcuts import render, redirect
from core.forms import *
from core.models import *
from django.views import generic
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages
# Create your views here.


def home(request):
    if request.POST:
        valor = request.POST['i_nome']
    valor = ''
    #print(f'valor={valor}')
    contexto = {'valor': valor}
    return render(request, 'core/index.html')

class Registrar(generic.CreateView):
    form_class = UserCreationForm
    success_url = '/'
    template_name = 'registration/register.html'

def cadastro_cliente(request):
    try:
        form = FormCliente(request.POST or None, request.FILES or None)
        if form.is_valid():
            nome = form.cleaned_data['nome']
            form.save()
            messages.success(request, f'Cliente {nome} cadastrado com sucesso!')
            return redirect('url_principal')
        contexto = {'form': form, 'titulo':'Cadastro de Cliente',
                    'stringBotao':'Cadastrar'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)




def cadastro_veiculo(request):
    try:
        form = FormVeiculo(request.POST or None, request.FILES or None)
        if form.is_valid():
            form.save()
            return redirect('url_principal')
        else:
            contexto = {'form': form, 'titulo':'Cadastro de Veículo',
                        'stringBotao':'Cadastrar'}
            return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)


def lista_veiculos(request):
    dados = Veiculo.objects.all()
    if request.POST:
        if request.POST['pesquisa']:
            dados = Veiculo.objects.filter(placa=request.POST['pesquisa'])
    contexto = {'dados': dados}
    return render(request, 'core/lista_veiculos.html', contexto)

def tabela(request):
    try:
        form = FormTabela(request.POST or None)
        if form.is_valid():
            form.save()
            return redirect('url_lista_tabela')
        contexto = {'form': form, 'titulo': 'Cadastro de Preços',
                    'stringBotao': 'Cadastrar'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro': menssagem_erro}
        return render(request, '500.html', contexto)

def lista_clientes(request):
    try:
        dados = Cliente.objects.all()
        if request.POST:
            if request.POST['pesquisa']:
                dados = Cliente.objects.filter(nome=request.POST['pesquisa'])
        contexto = {'dados': dados}
        return render(request, 'core/lista_clientes.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def cadastro_fabricante(request):
    try:
        form = FormFabricante(request.POST or None, request.FILES or None)
        if form.is_valid():
            form.save()
            return redirect('url_principal')
        contexto = {'form': form, 'titulo':'Cadastro de Fabricante',
                        'stringBotao':'Cadastrar'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def lista_fabricantes(request):
    try:
        dados = Fabricante.objects.all()
        if request.POST:
            if request.POST['pesquisa']:
                dados = Fabricante.objects.filter(descricao=request.POST['pesquisa'])
        contexto = {'dados': dados}
        return render(request, 'core/lista_fabricantes.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def altera_cliente(request, id):
    try:
        objeto = Cliente.objects.get(id=id)
        form = FormCliente( request.POST or None, request.FILES or None,
                            instance=objeto )
        if form.is_valid():
            nome = form.cleaned_data['nome']
            form.save()
            messages.success(request, f'dados do cliente {nome} atualizados com sucesso!')
            return redirect('url_lista_clientes')
        contexto = {'form':form,'titulo':'Atualiza Cliente',
                    'StringBotao':'Salvar'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)


def exclui_cliente(request, id):
    try:
        object = Cliente.objects.get(id=id)
        if request.POST:
            object.delete()
            return redirect('url_lista_clientes')
        contexto = {'url':'/lista_clientes/','objeto':object.nome}
        return render(request, 'core/confirma_exclusao.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def exclui_veiculo(request, id):
    try:
        object = Veiculo.objects.get(id=id)
        if request.POST:
            object.delete()
            return redirect('url_lista_veiculos')
        contexto = {'url':'/lista_veiculos/','objeto':object.nome}
        return render(request, 'core/confirma_exclusao.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)



def cadastro_rotativo(request):
    try:
        form = FormRotativo(request.POST or None)
        if form.is_valid():
            form.save()
            return redirect('url_principal')
        contexto ={'form':form, 'titulo': 'Cadastro de Rotativo',
                   'stringBotao':'Cadastrar', 'calendario': True}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)


def listagem_rotativos(request):
    try:
        dados = Rotativo.objects.all()
        contexto = {'dados':dados}
        return render(request, 'core/listagem_rotativos.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)


def alterar_rotativo(request, id):
    try:
        objeto = Rotativo.objects.get(id=id)
        form = FormRotativo(request.POST or None, instance=objeto)
        if form.is_valid():
            objeto.calcula_total()
            form.save()
            return redirect('url_listagem_rotativos')
        contexto ={'form':form, 'titulo': 'Cadastro de Rotativo',
                   'stringBotao':'Cadastrar', 'calendario': True}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def lista_tabela(request):
    try:
        dados = Tabela.objects.all()
        if request.POST:
            if request.POST['pesquisa']:
                dados = Tabela.objects.filter(descricao=request.POST['pesquisa'])
        contexto = {'dados': dados}
        return render(request, 'core/tabela_preco.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def cadastro_mensalista(request):
    try:
        form = FormMensalista(request.POST or None)
        if form.is_valid():
            form.save()
            return redirect('url_lista_mensalistas')
        contexto = {'form':form, 'título':'Cadastro de Mensalista',
                    'stringBotao':'Cadastro'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def lista_mensalistas(request):
    try:
        dados = Mensalista.objects.all()
        contexto = {'dados':dados}
        return render(request, 'core/lista_mensalistas.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)

def alterar_mensalista(request, id):
    try:
        objeto = Mensalista.objects.get(id=id)
        form = FormMensalista(request.POST or None, instance=objeto)
        if form.is_valid():
            objeto.calcula_total()
            form.save()
            return redirect('url_lista_mensalistas')
        contexto = {'form': form, 'titulo': 'Cadastro de Mensalista',
                    'stringBotao': 'Cadastrar'}
        return render(request, 'core/cadastro.html', contexto)
    except Exception as menssagem_erro:
        contexto = {'msg_erro':menssagem_erro}
        return render (request, '500.html', contexto)